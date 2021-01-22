const neDB = require('../configurations/database');
const api = {};

api.findAll = (request, response) => {
  neDB
    .find({})
    .sort({ name: 1 })
    .exec((exception, customers) => {
      if (exception) {
        console.log('Opa, deu ruim na tentativa de listar todos os customers', exception);
      }

      response.json(customers);
    });
};

api.save = (request, response) => {
  const canonical = request.body;

  neDB.insert(canonical, (exception, customers) => {
    if (exception) {
      console.log('Opa, deu ruim na tentativa de inserir o customers', exception);
    }

    response.status(201).json(customers);
  });
};

api.findOne = (request, response) => {
  const req = request.params.id;
  console.log(req);

  neDB.findOne({ name: req }).exec((exception, customers) => {
    if (exception || customers === null) {
      const setence = 'Customer not found';
      console.log(setence, exception);
      response.status(400);
      response.json({ mensagem: setence });
    }
    response.json(customers);
  });
};

api.update = (request, response) => {
  const req = request.params.id;
  const { name, age, description } = request.body;

  console.log(name, age, description);

  neDB.update(
    { _id: req },
    { name: name, age: age, description: description },
    (exception, customers) => {
      if (exception || customers === 0) {
        const setence = 'Custumer not found';
        console.log(setence, exception);
        response.status(400).json({ mensagem: setence });
      }
      response.json(customers);
    }
  );
};

api.delete = (request, response) => {
  const req = request.params.id;

  console.log(req);

  neDB.remove({ _id: req }, {}, (exception, customers) => {
    if (exception || customers === 0) {
      const setence = 'Customer not found';
      console.log(setence, exception);
      return response.status(400).json({ mensagem: setence });
    } else {
      return response.status(200).json(customers);
    }
  });
};

module.exports = api;

//https://github.com/louischatriot/nedb
