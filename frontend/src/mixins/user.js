import store from '../stores';

export default {
  methods: {
    userExists() {
      return !!store.getters.user.id;
    },
  },
};
