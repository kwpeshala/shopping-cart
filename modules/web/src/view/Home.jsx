import React,{Component} from "react";

class Home extends Component {
    constructor(prop){
        super(prop)
    }

    render() {
        const onButtonClick=()=>{
            this.props.history.push("./registration");
        };

        return (
            <div>
                <div>
                    <button onClick={onButtonClick}>Create User</button>
                </div>
            </div>

        );
    }
}

export default Home