const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: {
        vendor: ['vue', 'axios', 'jquery', 'bootstrap'],
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
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ['env']
                    }
                }]
            }
        ]
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
    }
};
