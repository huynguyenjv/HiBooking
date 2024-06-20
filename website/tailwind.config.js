/** @type {import('tailwindcss').Config} */
import tailwindScrollbar from "tailwind-scrollbar";

export default {
    content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
    theme: {
        extend: {
            colors: {
                primary: "#FF7F3E",
                secondary: "#80C4E9",
                third: "#FFF6E9",
            },
        },
    },

    plugins: [tailwindScrollbar],
};
