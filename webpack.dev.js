const merge = require('webpack-merge');
const path = require('path');
const common = require('./webpack.config.js');

/**
 * @type {import('webpack').Configuration}
 */
module.exports = merge(common, {
  devtool: 'source-map',
  devServer: {
    inline: true,
    contentBase: [
        path.join(__dirname, '/src/main/resources/templates'), // eslint-disable-line
    ],
    before: function(app) {
      app.use('/api', function (req, res) {
        res.type('application/json')
        // Note: directory traversal
        res.sendFile(path.join(__dirname, '/src/test/js/json', req.originalUrl + ".json")) // eslint-disable-line
      })
    },
    watchContentBase: true,
    port: 9080,
    open: true,
    openPage: "home.html"
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.js'
    }
  },
  performance: {
    hints: false
  }
});
