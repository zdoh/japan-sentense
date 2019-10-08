const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');
const webpack = require('webp' +
  '' +
  '' +
  'ack');

module.exports = {
  entry: './src/ui/index.js',
  output: {
    path: path.resolve(__dirname, 'target/classes/public/'),
    filename: 'bundle.min.js',
    libraryTarget: 'umd'
  },

  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components|build)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env', 'react']
          }
        }
      }
    ]
  },

  devServer: {
    contentBase: path.resolve(__dirname) + '/src/ui',
    compress: true,
    port: 9000,
    host: 'localhost',
    open: true,
    historyApiFallback: true
  },

  plugins: [
    new webpack.DefinePlugin({
      "process.env": {
        NODE_ENV: JSON.stringify("production")
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false,
      },
      output: {
        comments: false,
      },
    }),
    new HtmlWebpackPlugin({
      filename: 'index.html',
      template: 'src/ui/index.html'
    })
  ]


};
