import React from 'react';

const InProgress = (props) => {
  const mes = props.mes ? props.mes : "Страница находится в разработке";

  return (
    <div className="justify-content-md-center" style={{color: "red"}}>
      {mes}
    </div>
  )
};

export default InProgress;