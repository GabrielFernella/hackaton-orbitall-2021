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

api.findById = (request, response) => {
  const req = request.params.id;
  console.log(req);

  neDB.findOne({ _id: req }, (exception, customers) => {
    if (exception || customers === null) {
      return response.status(404).json({ mensagem: 'User not found' });
    }
    return response.json(customers);
  });
};

api.findByName = (request, response) => {
  const req = request.params.name;
  console.log(req);

  neDB.findOne({ name: req }, (exception, customers) => {
    if (exception || customers === null) {
      response.json({ mensagem: 'User not found' });
    } else {
      response.json(customers);
    }
  });
};

api.update = (request, response) => {
  const req = request.params.id;
  const { name, age, description } = request.body;

  console.log(name, age, description);

  neDB.update(
    { _id: req },
    { name: name, age: age, description: description },
    (err, customers) => {
      if (err || customers === 0) {
        return response.status(404).json({ mensagem: 'User not found' });
      }
      return response.status(200).json(request.body);
    }
  );
};

api.delete = (request, response) => {
  const req = request.params.id;

  console.log(req);

  neDB.remove({ _id: req }, {}, (err, customers) => {
    if (err || customers === 0) {
      return response.status(404).json({ mensagem: 'User not found' });
    }
    return response.status(200).json({ message: 'Deleted' });
  });
};

module.exports = api;

//https://github.com/louischatriot/nedb
