const config = {
  ktor: {
    deployment: {
      port: 8080,
      port: process.env.PORT
    },
    application: {
      modules: ['com.schooladmin.ApplicationKt.module']
    }
  },
  jwt: {
    domain: 'https://jwt-provider-domain/',
    audience: 'jwt-audience',
    realm: 'ktor sample app'
  }
};
