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

api.findPage = (request, response) => {
  const req = request.params.name;
  const { page, limit, sort } = request.query;
  console.log(req);

  db.find({})
    .sort({ name: 1 })
    .skip(1)
    .limit(2)
    .exec((exception, docs) => {
      if (exception || docs === null) {
        console.log('Não Passou');
        return response.json({ mensagem: 'User not found' });
      } else {
        console.log('Passou');
        return response.json({ message: 'Passou porra' });
      }
    });
};

api.update = (request, response) => {
  const req = request.params.id;
  const {
    cardNumber,
    embossName,
    customerName,
    documentNumber,
    motherName,
    address,
    city,
  } = request.body;

  console.log(request.body);

  neDB.update(
    { _id: req },
    {
      cardNumber,
      embossName,
      customerName,
      documentNumber,
      motherName,
      address,
      city,
    },
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
