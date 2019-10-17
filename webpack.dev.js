const merge = require('webpack-merge');
const common = require('./webpack.config.js');

module.exports = merge(common, {
    devtool: 'inline-source-map',
    devServer: {
        inline: true,
        contentBase: [
            path.join(__dirname, '/src/main/resources/templates'), // eslint-disable-line
            path.join(__dirname, '/src/main/resources/static'), // eslint-disable-line
        ],
        watchContentBase: true,
        port: 9000,
        open: true,
        openPage: "home.html"
    }
});
