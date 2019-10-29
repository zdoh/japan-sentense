import React, {Component} from 'react';
import {connect} from "react-redux";

import axios from "axios";
import Form from "react-bootstrap/Form";
import MySpin from "../../MySpin/MySpin";
import Input from "../../Input/Input";
import Button from "../../Button/Button";
import Option from "../../Option/Option";
import Table from "react-bootstrap/Table";

class Textbook extends Component {
  option = new Option();

  state = {
    textbook: null,
    loaded: false,
  };

  componentDidMount() {
    const {id} = {...this.props.match.params};
    this.getTextbook(id)
  }

  getTextbook = (id) => {
    axios.get(`/textbook/${id}`, {headers: {Authorization: 'Bearer ' + this.props.token}})
      .then(response => {
        console.log(response.data);
        this.setState({
          textbook: response.data,
          loaded: true
        });

      }).catch(error => {
      console.log(error);
      this.setState({
        loaded: true
      })
    });
  };

  render() {
    let result = !this.state.textbook ? <p>Нет такого учебника!!!</p> : <MySpin/>;
    if (this.state.loaded) {
      if (this.state.textbook) {
        const textbook = {...this.state.textbook};
        result = (
          <div>
            <h1>{textbook.japaneseName}</h1>
            <h1>{textbook.englishName}</h1>
            {textbook.lessonList.map(lesson => {
              let words = null;
              if (lesson.wordList !== null) {
                words = (
                  <div>
                    <h3 className="text-dark">Слова</h3>
                    {
                      lesson.wordList.map(word => {
                        return (
                          <Table striped bordered hover responsive="md" size="sm">
                            <React.Fragment key={word.id}>
                              <tr className="d-flex">
                                <td className="col-3">{word.wordKanji}</td>
                                <td className="col-3">{word.pronunciation}</td>
                                <td className="col-6">
                                  {
                                    word.translateEntities.filter(a => {
                                      return a.language.shortName === this.option.getLanguage()
                                    }).map(a => {
                                      return a.translate
                                    })
                                  }
                                </td>
                              </tr>
                            </React.Fragment>
                          </Table>
                        )
                      })
                    }
                  </div>
                )
              }

              let sentence = null;
              if (lesson.sentencesList !== null) {
                sentence = (
                  <div>
                    <h3 className="text-dark">Предложения</h3>
                    {lesson.sentencesList.map(sentence => {
                      return (
                        <Table striped bordered hover responsive="md" size="sm">
                          <React.Fragment key={sentence.id}>
                            <tr className="d-flex">
                              <td className="col-6">{sentence.sentence}</td>
                              <td className="col-6">
                                {sentence.translateList.filter(s => {
                                  return s.language.shortName === this.option.getLanguage();
                                }).map(s => {
                                  return s.translate;
                                })}
                                }
                              </td>
                            </tr>
                          </React.Fragment>
                        </Table>
                      )
                    })}
                  </div>
                )

              }

              let kanjis = null;

              if(lesson.kanjiList !== null) {
                kanjis = (
                  <div>
                    <h3 className="text-dark">Иероглифы</h3>
                    {
                      lesson.kanjiList.map(kanji => {
                        return (
                          <Table striped bordered hover responsive="md" size="sm">
                            <React.Fragment key={kanji.id}>
                              <tr className="d-flex">
                                <td className="col-3">{kanji.kanji}</td>
                                <td className="col-6">
                                  {
                                    kanji.meaning.filter(a => {
                                      return a.language.shortName === this.option.getLanguage()
                                    }).map(a => {
                                      return a.translate
                                    })
                                  }
                                </td>
                              </tr>
                            </React.Fragment>
                          </Table>
                        )
                      })
                    }
                  </div>
                )
              }

              return (
                <div>
                  <h2 className="text-dark">{lesson.name}</h2>
                  {words}
                  {sentence}
                  {kanjis}
                </div>
              )
            })}

          </div>
        )
      }
    }

    return (
      <div className="text-dark">
        {result}
        <p>sdasdad</p>
      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    token: state.token
  }
};


export default connect(mapStateToProps)(Textbook);