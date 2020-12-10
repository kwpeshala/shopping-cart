import React, {Component} from 'react'
import Field from "./Field";
import NavBar from "./NavBar";

class PriceCalculator extends Component {

    constructor(prop) {
        super(prop);

        this.state = {
            isLoading: false,
            productList: [],
            purchaseTypeList: ["carton", "unit"],
            purchaseType : "carton",
            productName: "",
            totalPrice:0.00,
            numberOfItems:0
        };

        this.baseState = this.state
    }


    async componentDidMount() {
        const productResponse = await fetch('/api/product');
        const productResponseBody = await productResponse.json();
        const defaultProduct = productResponseBody[0];

        this.setState({
            isLoading: false, productList:productResponseBody, productName:defaultProduct
        });


    }

    render() {
        const {isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }

        const fields=[
            {filedCategory:"dropDownField", fieldName:"Product  ", field:"productName", fieldRequired:true, optionList:this.state.productList, fieldValue:this.state.productName},
            {filedCategory:"dropDownField", fieldName:"Purchase Type  ", field:"purchaseType", fieldRequired:true, optionList:this.state.purchaseTypeList, fieldValue:this.state.purchaseType},
            {filedCategory:"inputField", fieldName:"Number of Items * ", field:"numberOfItems", fieldType:"number", fieldRequired:true, fieldMin:0, fieldValue:this.state.numberOfItems}
            ];

        const changeHandler = (event) => {
            let nam = event.target.name;
            let val = event.target.value;
            this.setState({[nam]: val});
        };

        const handleSubmit =async dispatch => {
            dispatch.preventDefault();
            const totalPriceResponse = await fetch(`/api/calculator?productName=${this.state.productName}&purchaseType=${this.state.purchaseType}&numberOfItems=${this.state.numberOfItems}`);
            const  totalPriceResponseBody = await  totalPriceResponse.json();
            this.setState({totalPrice:totalPriceResponseBody});
        };

        const handleClear=(e)=>{
            this.setState({totalPrice:0,
                productName:this.state.productList[0],
                purchaseType:this.state.purchaseTypeList[0],
                numberOfItems: 0
            })

        };

        const onPriceCalculator = () => {
            this.props.history.push("/price/calculator");
        };

        const onPriceList = () => {
            this.props.history.push("/");
        };

        return (
            <div>
                <button onClick={onPriceList}>Price List</button>
                <button onClick={onPriceCalculator}>Price Calculator</button>
                <form onSubmit={handleSubmit}>
                    <h1>Price Calculator</h1>

                    <div>
                        {fields.map((item)=>{
                            return <Field filedCategory={item.filedCategory}
                                          fieldName={item.fieldName}
                                          field={item.field}
                                          fieldMin ={item.fieldMin}
                                          fieldType={item.fieldType}
                                          fieldChange={changeHandler}
                                          fieldValue={item.fieldValue}
                                          fieldRequired={item.fieldRequired}
                                          optionList={item.optionList}
                            />
                        })}
                    </div>

                    <div className="submit">
                        <button onClick={handleClear}>Clear</button>
                        <button>Submit</button>
                    </div>
                </form>

                <div>Total Price : {this.state.totalPrice.toFixed(2)}</div>
            </div>
        );
    }
}

export default PriceCalculator