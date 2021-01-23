const neDB = require('../configurations/database');
const api = {};

api.findAll = (request, response) => {
  neDB
    .find({})
    .sort({ name: 1 })
    .exec((exception, cards) => {
      if (exception) {
        console.log('Opa, deu ruim na tentativa de listar todos os cards', exception);
      }

      response.json(cards);
    });
};

api.save = (request, response) => {
  const canonical = request.body;

  neDB.insert(canonical, (exception, cards) => {
    if (exception) {
      console.log('Opa, deu ruim na tentativa de inserir os cards', exception);
    }

    response.status(201).json(cards);
  });
};

api.findById = (request, response) => {
  const req = request.params.id;
  console.log(req);

  neDB.findOne({ _id: req }, (exception, cards) => {
    if (exception || cards === null) {
      return response.status(404).json({ mensagem: 'cards not found' });
    }
    return response.json(cards);
  });
};

api.findPage = (request, response) => {
  const skip = request.query.skip;
  const limit = request.query.limit;
  //const sort = request.query.sort;

  console.log(skip, limit);

  neDB
    .find({})
    .sort({ cardNumber: 1 })
    .limit(limit)
    .skip(skip)
    .exec((exception, docs) => {
      if (exception || docs === null) {
        return response.json({ mensagem: 'cards not found' });
      } else {
        return response.status(200).json(docs);
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
    (err, cards) => {
      if (err || cards === 0) {
        return response.status(404).json({ mensagem: 'User not found' });
      }
      return response.status(200).json(request.body);
    }
  );
};

api.delete = (request, response) => {
  const req = request.params.id;

  console.log(req);

  neDB.remove({ _id: req }, {}, (err, cards) => {
    if (err || cards === 0) {
      return response.status(404).json({ mensagem: 'User not found' });
    }
    return response.status(200).json({ message: 'Deleted Card' });
  });
};

module.exports = api;
