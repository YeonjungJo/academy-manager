module.exports = {
  proxyTable: {
    '/api': {
      target: 'http://local.enable.com:10001/api',
      changeOrigin: true,
      pathRewrite: {
        '^/api': '',
      },
    },
  },
};