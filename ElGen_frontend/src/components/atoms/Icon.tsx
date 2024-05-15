import React from 'react';

interface IconProps {
    iconName?: string;
    iconSource?: string;
    altName?: string;
    className?: string;
    imageSize?: string;
}

export const Icon: React.FC<IconProps> = (props) => {
    const { iconSource, altName, className, imageSize } = props;

    return (
        <div>
            {iconSource && (
                <img
                    src={iconSource}
                    alt={altName}
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
