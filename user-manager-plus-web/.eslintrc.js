module.exports = {
    root: false,
    env: {
        browser: true,
        node: false,
        es6: true,
        mocha: false,
        jest: false,
        jasmine: false,
    },
    parser: '@typescript-eslint/parser',
    settings: {
        "react": {
            "pragma": "React",
            "version": "detect"
        }
    },
    extends: [
        'standard',
        'plugin:react/recommended',
        'plugin:@typescript-eslint/recommended' // Uses the recommended rules from the @typescript-eslint/eslint-plugin
    ],
    parserOptions: { //指定ESLint可以解析JSX语法
        "ecmaVersion": 2019,
        "sourceType": 'module',
        "ecmaFeatures": {
            jsx: true
        }
    }
};