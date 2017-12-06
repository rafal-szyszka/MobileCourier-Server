<template>
<div class="container">
  <div class="row">
    <div class="col-sm-4">
    </div>
    <div personId="login-form" class="col-sm-4">
      <img personId="logo" src="../../assets/imgs/logo.png" />
      <form>
      <div class="form-group">
        <label>Login:</label>
        <input class="form-control" placeholder="Enter your login" v-model="credentials.login"/>
      </div>
      <div class="form-group">
        <label>Password:</label>
          <input class="form-control" placeholder="Enter your password" v-model="credentials.password"/>
      </div>
      <label personId="sign-in-btn" @click="signIn">Sign In</label>
      </form>
    </div>
  </div>
</div>
</template>

<script>
  export default {
    data() {
      return {
        credentials: {}
      }
    },
    methods: {
      signIn() {
        console.log(this.credentials.login);
      }
    }
  }
</script>


<style>

#logo {
  margin-bottom: 30px;
}

#login-form {
  background: #FCFCFC;
  border-radius: 1em;
  box-shadow: 10px 10px 20px 15px #565656;
  letter-spacing: 2px;
  margin-top: 40px;
  padding: 10px 20px 10px 20px;
}

#login-form label{
  font-family: 'Raleway', sans-serif;
  font-size: 22px;
  font-weight: 300;
}

#sign-in-btn {
  background-color: #FFFFFF;
  border: solid 1px;
  border-radius: 5px;
  font-size: 20px;
  margin-top: 10px;
  padding: 5px;
}

#sign-in-btn:hover {
  background-color: #EEEEEE;
  border-color: #888888;
}

</style>
