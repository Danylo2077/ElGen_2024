import React from 'react';

interface IconProps {
    iconName?: string;
    iconSource?: string;
    altName?: string;
    className?: string;
    imageSize?: string;
    id?:string;
}

export const Icon: React.FC<IconProps> = (props) => {
    const { iconSource, id, altName, className, imageSize } = props;

    return (
        <div>
            {iconSource && (
                <img
                    src={iconSource}
                    alt={altName}
                    id={id}
                    className={className}
                    style={{
                        width: imageSize,
                        height: imageSize,
                        objectFit: 'cover' // Добавляем свойство objectFit
                    }}
                />
            )}
        </div>
    );
};


export default Icon;
