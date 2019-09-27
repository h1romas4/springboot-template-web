const webpack = require('webpack');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const path = require('path');

module.exports = {
    mode: 'production',
    entry: {
        vendor: ['vue', 'axios', 'jquery', 'popper.js', 'bootstrap'],
        home: './src/main/js/home/main.js'
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
        }),
        new VueLoaderPlugin()
    ],
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }]
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
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
    },
    performance: {
        maxAssetSize: 300000,
        maxEntrypointSize: 300000
    }
};
