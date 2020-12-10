import React from "react";
import InputField from "./InputField";
import DropDownField from "./DropDownField";

const Field = (props)=> {
    return (
        <div>
            {props.filedCategory=="inputField" &&
                <InputField fieldName={props.fieldName}
                            field={props.field}
                            fieldMin ={props.fieldMin}
                            fieldType={props.fieldType}
                            fieldValue={props.fieldValue}
                            fieldChange={props.fieldChange}
                            fieldRequired={props.fieldRequired}

                />
            }
            {props.filedCategory=="dropDownField" &&
            <DropDownField
                fieldName={props.fieldName}
                field={props.field}
                fieldChange={props.fieldChange}
                fieldValue ={props.fieldValue}
                fieldRequired={props.fieldRequired}
                optionList={props.optionList.map(item => (
                    <option key={item}>{item}</option>
                ))}
            />
            }
        </div>
    )
};

export default Field;