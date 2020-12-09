import React, {Component} from "react";

class NavBar extends Component{
    constructor(prop){
        super(prop)
    }

    render() {
        const onClickOnPriceList=()=>{
            this.props.history.push("/");
        };

        const onClickOnPriceCalculator=()=>{
            this.props.history.push("/price/calculator");
        };

        return (
            <div>
               <table>
                   <tr>
                       <td onClick={onClickOnPriceList}>Price List</td>
                       <td onClick={onClickOnPriceCalculator}>Price Calculator</td>
                   </tr>
               </table>
            </div>

        );
    }
}

export default NavBar;