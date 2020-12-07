import React from "react";
import InputField from "./InputField";
import DropDownField from "./DropDownField";

const Field = (props)=> {
    return (
        <div>
            {props.filedCategory=="inputField" &&
                <InputField fieldName={props.fieldName}
                            field={props.field}
                            fieldType={props.fieldType}
                            fieldChange={props.fieldChange}
                            fieldRequired={props.fieldRequired}

                />
            }
            {props.filedCategory=="dropDownField" &&
            <DropDownField
                fieldName={props.fieldName}
                field={props.field}
                fieldChange={props.fieldChange}
                fieldRequired={props.fieldRequired}
                optionList={props.optionList.map(gender => (
                    <option key={gender}>{gender}</option>
                ))}
            />
            }
        </div>
    )
};

export default Field;