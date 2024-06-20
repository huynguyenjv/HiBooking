import Form from "./components/Form";
import LocationParosel from "./components/LocationCarousel";
import Promotion from "./components/Promotion";
import TravelNews from "./components/TravelNews";

export default function Home() {
    return (
        <main>
            <Form />
            <LocationParosel />
            <Promotion />
            <TravelNews />
        </main>
    );
}
