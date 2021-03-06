import React, {Component} from 'react';
import axios from "axios";


import {Container} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Quiz from "../Quiz/Quiz";
import Col from "react-bootstrap/Col";
import Option from "../../Option/Option";
import {connect} from "react-redux";

class StudySentence extends Component {
  option = new Option();

  state = {
    sentence: null,
  };

  componentDidMount() {
    this.getRandSentence();
  }

  getRandSentence() {
    axios.get('/sentence/random', {headers: {Authorization: 'Bearer ' + this.props.token}})
      .then(response => {
        this.setState({
          sentence: response.data,
          checkAnswer: false
        });

      }).catch(error => {
      console.log(error);
    });
  }

  goodAnswerHandler = () => {
    // todo
    // после добавление пользователей счетчик правильных ответов для предложения для пользователя
    this.getRandSentence();
  };

  badAnswerHandler = () => {
    // todo
    // после добавление пользователей счетчик перавильных ответов для предложения для пользователя
    this.getRandSentence();
  };

  render() {
    let question = null;
    let answer = null;

    if (this.state.sentence !== null) {
      const sent = {...this.state.sentence};

      let politeness = sent.politeness.translateEntities.filter(p => {
        return p.language.shortName === this.option.getLanguage();
      }).map(p => {
        return p.translate;
      });

      let conversation = sent.conversation ? "**Разговорная речь" : "";

      question = (
        <div>
          <Row className="justify-content-md-center">{sent.translateList.filter(s => {
            return s.language.shortName === this.option.getLanguage();
          }).map(s => {
            return s.translate;
          })}
          </Row>
          <Row>
            <Col style={{color: "blue", textAlign: 'right'}}>{politeness}</Col>
            <Col style={{color: "green"}}>{conversation}</Col>
          </Row>

        </div>
      );

      answer = (
        <Container>
          <Row className="justify-content-md-center">{sent.sentence}
          </Row>
        </Container>
      )

    }

    return (
      <Quiz
        question={question}
        answer={answer}
        badAnswerButton={this.badAnswerHandler}
        goodAnswerButton={this.goodAnswerHandler}/>
    )
  }
}

const mapStateToProps = state => {
  return {
    token: state.token
  }
};


export default connect(mapStateToProps)(StudySentence);