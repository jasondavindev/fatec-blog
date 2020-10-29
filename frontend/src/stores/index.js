import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {
      id: null,
      name: null,
      email: null,
    },
  },

  getters: {
    user: (state) => {
      const { id, name, email } = state.user;
      return { id, name, email };
    },
  },

  actions: {
    setUser({ state }, { id, name, email }) {
      state.user = {
        id,
        name,
        email,
      };

      console.log('[STORE] User set', { id, email, name });
    },
  },
});
