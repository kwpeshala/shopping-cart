import React,{Component} from "react";

class SuccessUserCreation extends Component {
    constructor(prop){
        super(prop)
    }

    render() {
        const onButtonClick=(e)=>{
            this.props.history.push("./registration");
        }

        return (
            <div>
                Successfully created the user.

                <div>
                    <button onClick={onButtonClick}>Back to Registration</button>
                </div>
            </div>

        );
    }
}

export default SuccessUserCreation