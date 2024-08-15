/** @type { import('@storybook/react').Preview } */
// .storybook/preview.js

import "../src/tailwind.css"; // replace with the name of your tailwind css file
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
