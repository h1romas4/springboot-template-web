const webpack = require('webpack');
const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
  mode: 'production',
  entry: {
    vendor: [
      'vue',
      'axios',
      'jquery',
      'popper.js',
      'bootstrap',
      './src/main/css/style.css'
    ],
    home: './src/main/js/home.js',
    signin: './src/main/js/signin.js',
    dashboard: './src/main/js/dashboard.js',
  },
  output: {
    filename: 'js/[name].bundle.js',
    path: path.join(__dirname, '/src/main/resources/static'), // eslint-disable-line
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
    new VueLoaderPlugin(),
    new MiniCssExtractPlugin({
      filename: 'css/[name].bundle.css',
    }),
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
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: MiniCssExtractPlugin.loader,
            options: {
              publicPath: '/css',
            },
          },
          "css-loader"
        ]
      },
      {
        test: /\.(ttf|otf|eot|woff|woff2)$/,
        use: [{
          loader: 'file-loader',
          options: {
            name: "[name].[ext]",
            outputPath: 'fonts/',
            publicPath: '/fonts'
          }
        }]
      },
      {
        test: /\.(png|jpg|svg)$/,
        use: [{
          loader: 'file-loader',
          options: {
            name: "[name].[ext]",
            outputPath: 'images/',
            publicPath: '/images'
          }
        }]
      },
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
