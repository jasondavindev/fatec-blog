<template>
  <div class="user-register-form m-4 text-left">
    <b-card title="Entrar">
      <b-form @submit.prevent="onSubmit">
        <div class="mt-2">
          <b-form-input v-model="email" placeholder="E-mail" autofocus></b-form-input>
        </div>
        <div class="mt-3">
          <b-button type="submit" variant="outline-primary">Entrar</b-button>
        </div>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

import BlogApi from '../services/api';

export default {
  data() {
    return {
      email: '',
    };
  },

  computed: {
    ...mapGetters(['user']),
  },

  mounted() {
    if (this.userExists()) {
      this.$router.push({ name: 'Posts' });
    }
  },

  methods: {
    ...mapActions(['setUser']),

    userExists() {
      const { id } = this.user;
      return id;
    },

    async onSubmit() {
      if (!this.validateForm()) return;

      await this.findUser();
    },

    validateForm() {
      return this.email;
    },

    setUserSession({ id, name, email }) {
      this.setUser({ id, name, email });
    },

    async findUser() {
      try {
        const { data } = await BlogApi.userLogin({
          email: this.email,
        });

        this.setUserSession(data);
        this.$router.push({ name: 'Posts' });
      } catch (error) {
        if (error.response.status === 404) {
          alert('Email não encontrado!');
        }
      }
    },
  },
};
</script>

<style>
</style>
