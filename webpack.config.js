const webpack = require('webpack');
const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

/**
 * @type {import('webpack').Configuration}
 */
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
    publicPath: "/",
    assetModuleFilename: 'res/[name].[hash][ext]'
  },
  optimization: {
    splitChunks: {
      cacheGroups: {
        vender: {
          name: 'depens',
          chunks: 'initial'
        }
      }
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
            presets: ['@babel/preset-env'],
            plugins: ['@babel/plugin-transform-runtime'],
          }
        }]
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
        test: /\.(sa|c)ss$/,
        use: [
          // 3rd loader
          {
            loader: MiniCssExtractPlugin.loader
          },
          // 2nd loader
          {
            loader: 'css-loader',
            options: {
              sourceMap: true
            },
          },
          // 1st loader
          {
            loader: 'sass-loader',
            options: {
              sourceMap: true
            },
          },
        ]
      },
      {
        test: /\.(ttf|otf|eot|woff|woff2)$/,
        type: 'asset/resource'
      },
      {
        test: /\.(png|jpg|svg)$/,
        type: 'asset/resource'
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
