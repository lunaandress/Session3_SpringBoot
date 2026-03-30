import PropTypes from "prop-types";
import { useEffect, useState } from "react";
import { listProdcut } from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";




export const ProductApp = ({title}) =>{

    const[products , setProduct]=useState([])
    useEffect(()=>{
        const result = listProdcut()
        setProduct(result)
    },[])
    return (
        <>
        <h1>{title.text}</h1>
        <ProductGrid products={products}/>
        </>
    )
}
ProductApp.propTypes={
        title:PropTypes.string.isRequired
    }