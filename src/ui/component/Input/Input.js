import React from 'react';
import Row from "react-bootstrap/Row";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import FormControl from "react-bootstrap/FormControl";
import FormGroup from "react-bootstrap/FormGroup";
import Button from "react-bootstrap/Button";


const input = (props) => {
  let inputElement = null;

  switch (props.elementType) {
    case ("input"):
      inputElement = (
        <FormGroup as={Row} className={props.classNames}>
          <Form.Label column sm={props.labelSize}>{props.label}</Form.Label>
          <Col sm={props.colSize}>
            <FormControl name={props.name} type="text" value={props.value} onChange={props.change}/>
          </Col>
        </FormGroup>
      );
      break;

    case ("submitButton"):
      inputElement = (
        <Form.Group as={Row}>
          <Col sm={{span: 10, offset: 2}}>
            <Button type="submit">{props.buttonName}</Button>
          </Col>
        </Form.Group>
      );

      break;
    default:
      inputElement = (
        <FormGroup as={Row} controlId="formBasicKanji" className="justify-content-md-center">
          <Form.Label column sm={props.labelSize}>{props.label}</Form.Label>
          <Col sm={props.colSize}>
            <FormControl type="text" value={props.value} onChange={props.change}/>
          </Col>
        </FormGroup>
      );

  }

  return (
    <div>
      {inputElement}
    </div>

  )
};

export default input;