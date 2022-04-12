const { merge } = require('webpack-merge');
const path = require('path');
const common = require('./webpack.config.js');

/**
 * @type {import('webpack').Configuration}
 */
module.exports = merge(common, {
  devtool: 'source-map',
  devServer: {
    static: {
        directory: path.join(__dirname, '/src/main/resources/templates'), // eslint-disable-line
    },
    watchFiles: ['src/main/js/**/*', 'src/main/css/**/*'],
    port: 9080,
    onAfterSetupMiddleware: function (devServer) {
      devServer.app.use('/api', function (req, res) {
        res.type('application/json')
        // Note: directory traversal
        res.sendFile(path.join(__dirname, '/src/test/js/json', req.originalUrl + ".json")) // eslint-disable-line
      })
    },
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
