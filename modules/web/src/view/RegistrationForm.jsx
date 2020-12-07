import React, {Component} from 'react'
import Field from "./Field";

class RegistrationForm extends Component {

    constructor(prop) {
        super(prop);

        this.state = {
            isLoading: true,
            genderList: [],
            bankNameList: [],
            email: "",
            firstName: "",
            gender: "",
            bankName: "",
            dateOfBirth: ""
        };
    }


    async componentDidMount() {
        const response = await fetch('/api/users');
        const body = await response.json();
        const genderResponse = await fetch('/api/gender');
        const genderResponseBody = await genderResponse.json();
        const bankResponse = await fetch('/api/bank');
        const bankResponseBody = await bankResponse.json();
        const defaultGender = genderResponseBody[0];
        const defaultBankName = bankResponseBody[0];

        this.setState({
            groups: body, isLoading: false, genderList: genderResponseBody, bankNameList: bankResponseBody,
            gender: defaultGender, bankName: defaultBankName
        });


    }

    render() {
        const {isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }

        const fields=[
            {filedCategory:"inputField", fieldName:"Username * ", field:"username", fieldType:"text", fieldRequired:true},
            {filedCategory:"inputField", fieldName:"First Name ", field:"firstName", fieldType:"text", fieldRequired:false},
            {filedCategory:"inputField", fieldName:"Last Name ", field:"lastName", fieldType:"text", fieldRequired:false},
            {filedCategory:"inputField", fieldName:"NIC ", field:"nic", fieldType:"text", fieldRequired:false},
            {filedCategory:"inputField", fieldName:"Date of Birth ", field:"dateOfBirth", fieldType:"date", fieldRequired:true},
            {filedCategory:"dropDownField", fieldName:"Gender ", field:"gender", fieldRequired:true, optionList:this.state.genderList},
            {filedCategory:"inputField", fieldName:"Phone Number ", field:"msisdn", fieldType:"text", fieldRequired:false},
            {filedCategory:"inputField", fieldName:"Email Address * ", field:"email", fieldType:"email", fieldRequired:true},
            {filedCategory:"dropDownField", fieldName:"Bank Name ", field:"bankName", fieldRequired:true, optionList:this.state.bankNameList},
            {filedCategory:"inputField", fieldName:"Account No ", field:"accountNumber", fieldType:"text", fieldRequired:false}
            ];

        const changeHandler = (event) => {
            let nam = event.target.name;
            let val = event.target.value;
            this.setState({[nam]: val});
        };

        const handleSubmit = () => {
            fetch('/api/add/user', {
                method: 'POST',
                body: JSON.stringify(this.state),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (response) {
                console.log(response);
                // return response.json();
            });
            this.props.history.push("./success");
        };

        return (
            <form onSubmit={handleSubmit}>
                <h1>Create Account</h1>

                <div>
                    {fields.map((item)=>{
                        return <Field filedCategory={item.filedCategory}
                                      fieldName={item.fieldName}
                                      field={item.field}
                                      fieldType={item.fieldType}
                                      fieldChange={changeHandler}
                                      fieldRequired={item.fieldRequired}
                                      optionList={item.optionList}
                        />
                    })}
                </div>

                <div className="submit">
                    <button>Submit</button>
                </div>


            </form>
        );
    }
}

export default RegistrationForm