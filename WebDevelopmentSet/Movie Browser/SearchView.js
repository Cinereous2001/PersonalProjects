import Hero from "./Hero";
const SearchView = ({keyword, searchResults}) => {

    const title = `You are searching for ${keyword}...`;
    console.log(`${searchResults} are the search results`);
    return(
        <Hero name = {title} />
    )
}

export default SearchView;