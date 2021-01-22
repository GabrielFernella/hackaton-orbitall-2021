const api = require('../controllers/customer-controller');

module.exports = (app) => {
  app.route('/customers').get(api.findAll).post(api.save);

  app.route('/customers/:id').get(api.findOne).put(api.update).delete(api.delete);
};
