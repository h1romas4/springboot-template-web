const webpack = require('webpack');
const path = require('path');

module.exports = {
    mode: 'production',
    entry: {
        vendor: ['vue', 'axios', 'jquery', 'popper.js', 'bootstrap'],
        home: './src/main/js/home.js'
    },
    output: {
        filename: '[name].bundle.js',
        path: path.join(__dirname, '/src/main/resources/static/js') // eslint-disable-line
    },
    optimization: {
        splitChunks: {
            name: 'vendor',
            chunks: 'initial'
        }
    },
    devtool: 'source-map',
    plugins: [
        // for bootstrap jQuery plugin
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        })
    ],
    module: {
        rules: [{
            test: /\.js$/,
            exclude: /node_modules/,
            use: [{
                loader: 'babel-loader',
                options: {
                    presets: ['@babel/preset-env']
                }
            }]
        }]
    },
    // for production vue.js
    // @see https://vuejs.org/guide/deployment.html
    resolve: {
        extensions: ['.js', '.vue'],
        modules: [
            "node_modules"
        ],
        alias: {
            vue: 'vue/dist/vue.min.js'
        }
    },
    performance: {
        maxAssetSize: 300000,
        maxEntrypointSize: 300000
    }
};
