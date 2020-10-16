<template>
  <div class="user-register-form m-4 text-left">
    <b-card title="Registrar">
      <b-form @submit.prevent="onSubmit">
        <div>
          <b-form-input v-model="name" placeholder="Usuário"></b-form-input>
        </div>
        <div class="mt-2">
          <b-form-input v-model="email" placeholder="E-mail"></b-form-input>
        </div>
        <div class="mt-3">
          <b-button type="submit" variant="outline-primary">Registrar</b-button>
        </div>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import BlogApi from '../services/api';

export default {
  data() {
    return {
      name: '',
      email: '',
    };
  },
  methods: {
    async onSubmit() {
      if (!this.validateForm()) return;

      await this.createUser();
    },

    validateForm() {
      return this.name && this.email;
    },

    async createUser() {
      try {
        const { data } = await BlogApi.createUser({
          name: this.name,
          email: this.email,
        });

        return data;
      } catch (error) {
        return console.error(error);
      }
    },
  },
};
</script>

<style>
</style>
