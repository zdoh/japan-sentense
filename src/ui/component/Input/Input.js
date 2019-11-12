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
            <FormControl name={props.name} placeholder={props.placeholder} type="text" value={props.value}
                         onChange={props.change}/>
          </Col>
        </FormGroup>
      );
      break;

    case ("input2"):
      inputElement = (
        <FormGroup className={props.classNames}>
          <Form.Label>{props.label}</Form.Label>
          <FormControl name={props.name} placeholder={props.placeholder} type="text" value={props.value}
                       onChange={props.change}/>
        </FormGroup>
      );
      break;

    case ("password"):
      inputElement = (
        <FormGroup className={props.classNames}>
          <Form.Label>{props.label}</Form.Label>
          <FormControl name={props.name} placeholder={props.placeholder} type="password" value={props.value}
                       onChange={props.change}/>
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

    case ("button"):
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