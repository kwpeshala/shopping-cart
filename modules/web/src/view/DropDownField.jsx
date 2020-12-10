import React from 'react';

const DropDownField = (props) => {
    return (
        <div>
            <label className="lable">
                {props.fieldName}:
            </label>
            <select className="field"
                name={props.field}
                onChange={props.fieldChange}
                value={props.fieldValue}
                required={props.fieldRequired}>
                {props.optionList}
            </select>

        </div>
    )
};

export default DropDownField;