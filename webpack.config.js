const path = require('path');

module.exports = {
    mode: 'development',
    entry: [
        './src/main/js/app.js'
    ],
    output: {
        filename: 'bundle.js',
        path: path.join(__dirname, '/src/main/resources/static/js') // eslint-disable-line
    },
    devtool: 'source-map',
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
