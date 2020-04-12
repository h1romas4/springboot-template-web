import Vue from 'vue';
import axios from 'axios';
import './common/common.js'
import hello from './components/hello'

new Vue({
    el: '#vue-module',
    components: {
        'hello': hello
    },
    data: {
        items: []
    },
    mounted: function() {
        this.ajax();
    },
    methods: {
        ajax: function() {
            axios.get('/api/v1/home').then((res) => {
                this.items = res.data;
            });
        }
    }
});
