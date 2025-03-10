const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  outputDir: '../src/main/resources/static',
  transpileDependencies: true,
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true
      }
    }
  },
  filenameHashing: true
})
