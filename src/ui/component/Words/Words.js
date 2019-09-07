import React, {Component} from 'react';
import axios from 'axios';
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import {LinkContainer} from 'react-router-bootstrap';
import Option from "../Option/Option";
import InProgress from "../InProgress/InProgress";

class Words extends Component {
  option = new Option();

  state = {
    words: [],
  };

  componentDidMount() {
    this.getWords()
  }

  getWords() {
    axios.get('/words')
      .then(response => {
        this.setState({
          words: response.data
        });

      }).catch(error => {
      console.log(error);
    });
  }

  wordDeleteHandler(id) {
    axios.delete(`/word/${id}`)
      .then(() => {
        this.getWords();
      });

  };

  render() {
    const words = this.state.words.map(word => {

      if (word.dontShow !== true) {
        return (
          <React.Fragment key={word.id}>
            <tr className="d-flex">
              <td className="col-2">{word.wordKanji}</td>
              <td className="col-2">{word.pronunciation}</td>
              <td className="col-6">
                {
                  word.translateEntities.filter(a => {
                    return a.language.shortName === this.option.getLanguage()
                  }).map(a => {
                    return a.translate
                  })
                }
              </td>
              <td className="col-2">
                <LinkContainer to={`/word/${word.id}`}>
                  <Button variant="primary">Edit</Button>
                </LinkContainer>
                <Button variant="danger" onClick={() => this.wordDeleteHandler(word.id)}>Delete</Button>
              </td>
            </tr>
          </React.Fragment>
        )
      }
      return null;

    });

    return (
      <div className="container-fluid">
        <InProgress mes="Добавление новых слов находится в разработке"/>
        <Table striped bordered hover responsive="md" size="sm">
          <thead>
          <tr className="d-flex">
            <th className="col-2">Слово</th>
            <th className="col-2">Кана</th>
            <th className="col-6">Перевод</th>
            <th className="col-2">Действия</th>
          </tr>
          </thead>
          <tbody>
          {words}
          </tbody>
        </Table>
      </div>
    )
  }
}

export default Words;