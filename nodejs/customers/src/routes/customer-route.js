const api = require('../controllers/customer-controller');

module.exports = (app) => {
  app.route('/customers').get(api.findAll).post(api.save);

  app.route('/customers/:id').get(api.findById).put(api.update).delete(api.delete);

  app.route('/customer/:name').get(api.findByName);
};
