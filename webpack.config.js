const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: [
        './src/main/js/app.js'
    ],
    output: {
        filename: 'bundle.js',
        path: path.join(__dirname, '/src/main/resources/static/js') // eslint-disable-line
    },
    devtool: 'source-map',
    plugins: [
        new webpack.optimize.UglifyJsPlugin({
            sourceMap: true
        })
    ],
    module: {
        rules: [{
            test: /\.js$/,
            exclude: /node_modules/,
            use: [{
                loader: 'babel-loader',
                options: {
                    presets: ['env']
                }
            }]
        }]
    },
    resolve: {
        extensions: ['.js', '.vue'],
        modules: [
            "node_modules"
        ],
        alias: {
            vue: 'vue/dist/vue.min.js'
        }
    }
};
