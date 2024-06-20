import { Carousel } from "antd";
import LocationCarouselData from "../../../mocks/CarouselData";
export default function LocationCarousel() {
    return (
        <div className="grid justify-center grid-flow-row">
            <div className="flex justify-center mt-10">
                <div className="pb-2 text-gray-600 border-b-2 border-gray-200">
                    <h1 className="text-xl font-medium">Các Điểm Đến Thu Hút Nhất Việt Nam</h1>
                </div>
            </div>
            <div className="container mt-5 px-28">
                <Carousel arrows arrowSize="18" infinite={false} autoplay={true} c lassName="rounded-xl">
                    {LocationCarouselData.map((location) => (
                        <div key={location.id} className="flex items-center justify-center h-80 text-whit rounded-xl">
                            <img
                                src={location.image}
                                alt={location.name}
                                className="object-cover w-full h-full rounded-xl"
                            />
                            <h1 className="text-xl font-medium">{location.name}</h1>
                        </div>
                    ))}
                </Carousel>
            </div>
        </div>
    );
}
