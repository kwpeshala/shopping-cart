import React, {Component} from 'react'
class PriceListTable extends Component {

    constructor(prop) {
        super(prop);

        this.state = {
            isLoading: true,
            priceList: [{"productName":"", "numberOfUnits":"", "price":""}]
        };
    }


    async componentDidMount() {
        const priceListResponse = await fetch('/price/list');
        const priceListBody = await priceListResponse.json();

        this.setState({
            isLoading: false, priceList:priceListBody
        });


    }

    render() {
        const {isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }

        const onPriceCalculator = () => {
            this.props.history.push("./price/calculator");
        };

        const onPriceList = () => {
            this.props.history.push("./");
        };

        return (


            <div>
                <button onClick={onPriceList}>Price List</button>
                <button onClick={onPriceCalculator}>Price Calculator</button>
                <table className="priceList">
                    <tr>
                        <th>Product Name</th>
                        <th className="numer-align">Number of Units</th>
                        <th className="numer-align">Price</th>
                    </tr>

                    {this.state.priceList.map((item) => {
                        return <tr>
                            <td>{item.productName}</td>
                            <td className="numer-align">{item.numberOfUnits}</td>
                            <td className="numer-align">{item.price.toFixed(2)}</td>
                        </tr>

                    })}
                </table>
            </div>
        );
    }
}

export default PriceListTable