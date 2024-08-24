/** @type { import('@storybook/react').Preview } */
// .storybook/preview.js
const preview = {
    parameters: {
        controls: {
            matchers: {
                color: /(background|color)$/i,
                date: /Date$/i,
            },
        },
    },
};

export default preview;
