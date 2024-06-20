import { Carousel } from "antd";
export default function TravelNews() {
    return (
        <div className="grid grid-flow-row">
            <div className="flex justify-center mt-10">
                <div className="pb-2 text-gray-600 border-b-2 border-gray-200">
                    <h1 className="text-xl font-medium">Tin Tức Du Lịch Nổi Bật</h1>
                </div>
            </div>
            <div className="mt-5 px-28">
                <div className="grid grid-cols-4 gap-4">
                    <div className="grid col-span-1">
                        <div className="items-center justify-center flex-1 rounded-lg">
                            <Carousel arrows arrowSize="18" autoplay={true} dotPosition="left">
                                <div className="rounded-xl">
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl">
                                        <h1 className="text-xl font-medium">Tin Tức 1</h1>
                                    </div>
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl ">
                                        <h1 className="text-xl font-medium">Tin Tức 1</h1>
                                    </div>
                                </div>
                                <div className="rounded-xl">
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl">
                                        <h1 className="text-xl font-medium">Tin Tức 2</h1>
                                    </div>
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl ">
                                        <h1 className="text-xl font-medium">Tin Tức 2</h1>
                                    </div>
                                </div>
                                <div className="rounded-xl">
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl">
                                        <h1 className="text-xl font-medium">Tin Tức 2</h1>
                                    </div>
                                    <div className="w-full mb-2 bg-gray-300 h-44 rounded-xl ">
                                        <h1 className="text-xl font-medium">Tin Tức 2</h1>
                                    </div>
                                </div>
                            </Carousel>
                        </div>
                    </div>
                    <div className="grid col-span-3 ">
                        <div className="flex items-center justify-center h-44 rounded-xl bg-gradient-to-r from-blue-500 to-blue-700">
                            <h1 className="text-xl font-medium">Tin Tức 2</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
