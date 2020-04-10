const webpack = require('webpack');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const path = require('path');

module.exports = {
    mode: 'production',
    entry: {
        vendor: ['vue', 'axios', 'jquery', 'popper.js', 'bootstrap'],
        home: './src/main/js/home.js',
        signin: './src/main/js/signin.js',
        dashboard: './src/main/js/dashboard.js',
    },
    output: {
        filename: '[name].bundle.js',
        path: path.join(__dirname, '/src/main/resources/static/js'), // eslint-disable-line
        publicPath: "/js/",
    },
    optimization: {
        splitChunks: {
            name: 'vendor',
            chunks: 'initial'
        }
    },
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
    resolve: {
        extensions: ['.js', '.vue'],
        modules: [
            "node_modules"
        ],
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    performance: {
        maxAssetSize: 3000000,
        maxEntrypointSize: 3000000
    }
};
