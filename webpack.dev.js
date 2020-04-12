const merge = require('webpack-merge');
const path = require('path');
const common = require('./webpack.config.js');

module.exports = merge(common, {
    devtool: 'inline-source-map',
    devServer: {
      inline: true,
      contentBase: [
          path.join(__dirname, '/src/main/resources/templates'), // eslint-disable-line
      ],
      before: function(app) {
        app.use('/api', function (req, res, next) {
          res.type('application/json')
          res.sendFile(path.join(__dirname, '/src/test/js/json', req.originalUrl + ".json")) // eslint-disable-line
          next()
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
  }
);
