import React from 'react';

const InputField = (props) => {
    return (
        <div>
            <label className="lable">
                {props.fieldName}:
            </label>
            <input className="field"
                   name={props.field}
                   type={props.fieldType}
                   min = {props.fieldMin}
                   value={props.fieldValue}
                   onChange={props.fieldChange}
                   required={props.fieldRequired}/>

        </div>
    )
};

export default InputField;